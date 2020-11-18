import { Injectable } from '@angular/core';
import {AnalyticsImplementation} from './analytics-implementation';
import {Metric} from './metric';

@Injectable({
  providedIn: 'root'
})
export class AnalyticsService {

  constructor(private implementation: AnalyticsImplementation) { }

  record(metric: Metric): void {
    this.implementation.recordMetric(metric);
  }
}
