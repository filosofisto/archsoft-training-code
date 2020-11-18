import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {AnalyticsService} from './analytics.service';
import {AnalyticsImplementation} from './analytics-implementation';
import {Metric} from './metric';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    {
      provide: AnalyticsService,
      useFactory: () => {
        const loggingImplementation: AnalyticsImplementation = {
          recordMetric: (metric: Metric): void => {
            console.log('The metric: ', metric);
          }
        };

        return new AnalyticsService(loggingImplementation);
      }
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
