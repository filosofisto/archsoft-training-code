import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoadingComponent} from './components/common/loading/loading.component';
import {ConfirmComponent} from './components/common/confirm/confirm.component';
import {MessageComponent} from './components/common/message/message.component';
import {InputTextComponent} from './components/common/input-text/input-text.component';
import {InputSecretComponent} from './components/common/input-secret/input-secret.component';
import {InputMaskComponent} from './components/common/input-mask/input-mask.component';
import {LoginComponent} from './components/login/login.component';
import {ProductFormComponent} from './components/product/product-form/product-form.component';
import {ProductListComponent} from './components/product/product-list/product-list.component';
import {ProductViewComponent} from './components/product/product-view/product-view.component';
import {productServiceInjectables} from "./services/product.service";
import {httpRequestInterceptInjectables} from "./util/http-request-intercept";
import {jwtHttpRequestInterceptInjectables} from "./util/jwt-http-request-intercept";
import {messageNotificationServiceInjectables} from "./components/common/message/message-notification.service";
import {authServiceInjectables} from "./services/auth.service";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    LoadingComponent,
    ConfirmComponent,
    MessageComponent,
    InputTextComponent,
    InputSecretComponent,
    InputMaskComponent,
    LoginComponent,
    ProductFormComponent,
    ProductListComponent,
    ProductViewComponent
  ],
  imports: [
    BrowserModule.withServerTransition({ appId: 'serverApp' }),
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
    productServiceInjectables,
    messageNotificationServiceInjectables,
    httpRequestInterceptInjectables,
    jwtHttpRequestInterceptInjectables,
    authServiceInjectables
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
