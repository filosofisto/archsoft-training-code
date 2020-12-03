import {Injectable} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoadingNotificationService} from '../../../services/loading-notification.service';
import {catchError, map} from 'rxjs/operators';
import {MessageNotificationService} from '../../../services/message-notification.service';

@Injectable({
  providedIn: 'root'
})
export class HttpRequestIntercept implements HttpInterceptor {

  constructor(private loadingNotificationService: LoadingNotificationService,
              private messageNotificationService: MessageNotificationService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.loadingNotificationService.start(req.url);

    return next.handle(req)
      .pipe(
        catchError((err) => {
          this.loadingNotificationService.stop(req.url);
          this.messageNotificationService.notifyError(err.message);

          return err;
        })
      )
      .pipe(map<HttpEvent<any>, any>((evt: HttpEvent<any>) => {
        if (evt instanceof HttpResponse) {
          this.loadingNotificationService.stop(req.url);
        }

        return evt;
      }));
  }
}

export const httpRequestInterceptInjectables: Array<any> = [
  { provide: HTTP_INTERCEPTORS, useClass: HttpRequestIntercept, multi: true }
];

