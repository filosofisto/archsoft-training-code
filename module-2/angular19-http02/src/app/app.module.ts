import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {SearchBoxComponent} from './search-box/search-box.component';
import {SearchResultComponent} from './search-result/search-result.component';
import {YoutubeSearchComponent} from './youtube-search/youtube-search.component';
import {HttpClientModule} from '@angular/common/http';
import {youtubeSearchInjectables} from './you-tube-search.injectables';

@NgModule({
  declarations: [
    AppComponent,
    SearchBoxComponent,
    SearchResultComponent,
    YoutubeSearchComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [youtubeSearchInjectables],
  bootstrap: [AppComponent]
})
export class AppModule {
}
