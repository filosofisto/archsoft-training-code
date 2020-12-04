import {Injectable} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {LoadingNotificationService} from '../../../services/loading-notification.service';
import {catchError, map} from 'rxjs/operators';
import {MessageNotificationService} from '../../../services/message-notification.service';
import {AuthService} from '../../../services/auth.service';
import {Location} from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class HttpRequestIntercept implements HttpInterceptor {

  constructor(private loadingNotificationService: LoadingNotificationService,
              private messageNotificationService: MessageNotificationService,
              private authService: AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.loadingNotificationService.start(req.url);

    return next.handle(req)
      .pipe(
        catchError((err) => {
          this.loadingNotificationService.stop(req.url);
          this.messageNotificationService.notifyError(err.message);

          if (err.status === 401) {
            this.messageNotificationService.notifyError('You need to authenticate');
            this.authService.logout();
          }
          if (err.status === 403) {
            this.messageNotificationService.notifyError('You do not have permission');
          }

          return throwError(err);
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

