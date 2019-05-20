package com.products.sample.metrics;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//import io.opentracing.contrib.metrics.MetricLabel;
//import io.opentracing.contrib.metrics.label.BaggageMetricLabel;
//import io.opentracing.contrib.metrics.label.ConstMetricLabel;



@Configuration
public class MetricsConfiguration {

  /* @Bean
    public MetricLabel transactionLabel() {
        return new BaggageMetricLabel("transaction", "n/a");
    }

    @Bean
    public MetricLabel versionLabel() {
        return new ConstMetricLabel("version", System.getenv("VERSION"));
    }
*/
}


