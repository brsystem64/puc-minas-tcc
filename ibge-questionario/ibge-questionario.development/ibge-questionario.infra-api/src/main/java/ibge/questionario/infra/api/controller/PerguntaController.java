package ibge.questionario.infra.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibge.questionario.core.entity.Pergunta;
import ibge.questionario.service.pergunta.PerguntaService;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.exporter.otlp.logs.OtlpGrpcLogRecordExporter;
import io.opentelemetry.exporter.otlp.metrics.OtlpGrpcMetricExporter;
import io.opentelemetry.exporter.otlp.trace.OtlpGrpcSpanExporter;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.logs.SdkLoggerProvider;
import io.opentelemetry.sdk.logs.export.BatchLogRecordProcessor;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import io.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/pergunta")
@Log
public class PerguntaController {

	@Autowired
	private PerguntaService perguntaService;

	private static final String INSTRUMENTATION_NAME = PerguntaController.class.getName();

	@GetMapping
	public ResponseEntity<List<Pergunta>> getPergunta() {
		Resource resource = Resource.getDefault()
				.merge(Resource.create(Attributes.of(ResourceAttributes.SERVICE_NAME, "logical-service-name")));

		SdkTracerProvider sdkTracerProvider = SdkTracerProvider.builder()
				.addSpanProcessor(BatchSpanProcessor.builder(OtlpGrpcSpanExporter.builder().build()).build())
				.setResource(resource).build();

		SdkMeterProvider sdkMeterProvider = SdkMeterProvider.builder()
				.registerMetricReader(PeriodicMetricReader.builder(OtlpGrpcMetricExporter.builder().build()).build())
				.setResource(resource).build();

		SdkLoggerProvider sdkLoggerProvider = SdkLoggerProvider.builder()
				.addLogRecordProcessor(
						BatchLogRecordProcessor.builder(OtlpGrpcLogRecordExporter.builder().build()).build())
				.setResource(resource).build();

		OpenTelemetry openTelemetry = OpenTelemetrySdk.builder().setTracerProvider(sdkTracerProvider)
				.setMeterProvider(sdkMeterProvider).setLoggerProvider(sdkLoggerProvider)
				.setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
				.buildAndRegisterGlobal();

		Tracer tracer = openTelemetry.getTracer("instrumentation-library-name", "1.0.0");

		Span span = tracer.spanBuilder("teste").startSpan();
		span.makeCurrent();
		log.info("teste");
		try {
			return ResponseEntity.ok(perguntaService.consultaPerguntaPorSessao(1));
		} finally {
			log.info(Span.current().getSpanContext().getTraceId());
			span.end();
			
		}

	}
}
