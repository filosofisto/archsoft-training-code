import { Component } from '@angular/core';
import {AnalyticsService} from './analytics.service';
import {Metric} from './metric';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular16-di05';

  constructor(private analyticsService: AnalyticsService) {

  }

  sendAnalytics(context: string): boolean {
    this.analyticsService.record(new Metric('click', context));

    return false;
  }
}
