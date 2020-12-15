import {Injectable} from '@angular/core';
import {HTTP_INTERCEPTORS, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Observable} from 'rxjs';
import {AuthService} from '../../../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class JwtHttpRequestIntercept implements HttpInterceptor {

  constructor(private authService: AuthService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const currentUser = this.authService.currentUser;

    if (currentUser && currentUser.token) {
      req = req.clone({
        setHeaders: {
          Authorization: `Bearer ${currentUser.token}`
        }
      });
    }

    return next.handle(req);
  }
}

export const jwtHttpRequestInterceptInjectables: Array<any> = [
  { provide: HTTP_INTERCEPTORS, useClass: JwtHttpRequestIntercept, multi: true }
];

