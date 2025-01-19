package org.example.moviecachinggateway.sevice.metrics

import io.micrometer.core.instrument.MeterRegistry
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong

@Service
class MetricService(private val meterRegistry: MeterRegistry) {
    fun incrementHttpRequestCount() {
        meterRegistry.counter("requests_count").increment()
    }
}