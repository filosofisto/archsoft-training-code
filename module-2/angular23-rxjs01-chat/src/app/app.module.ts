import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from "@angular/common/http";

import { UsersService } from './service/users/users.service';
import { ThreadsService } from './service/threads/threads.service';
import { MessagesService } from './service/messages/messages.service';

import { AppComponent } from './app.component';
import { ChatMessageComponent } from './components/chat-message/chat-message.component';
import { ChatThreadComponent } from './components/chat-thread/chat-thread.component';
import { ChatNavBarComponent } from './components/chat-nav-bar/chat-nav-bar.component';
import { ChatThreadsComponent } from './components/chat-threads/chat-threads.component';
import { ChatWindowComponent } from './components/chat-window/chat-window.component';
import { ChatPageComponent } from './components/chat-page/chat-page.component';
import { FromNowPipe } from './pipes/from-now.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ChatMessageComponent,
    ChatThreadComponent,
    ChatNavBarComponent,
    ChatThreadsComponent,
    ChatWindowComponent,
    ChatPageComponent,
    FromNowPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    MessagesService, ThreadsService, UsersService
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
