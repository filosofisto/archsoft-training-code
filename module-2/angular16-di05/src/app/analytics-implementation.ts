import {Metric} from './metric';

export interface AnalyticsImplementation {

  recordMetric(metric: Metric): void;
}
