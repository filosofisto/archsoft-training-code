import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LocationStrategy, HashLocationStrategy, APP_BASE_HREF } from '@angular/common';

import { SPOTIFY_PROVIDERS } from './spotify.service';
import {SearchComponent} from './search/search.component';
import {ArtistsComponent} from './artists/artists.component';
import {TracksComponent} from './tracks/tracks.component';
import {AlbumComponent} from './album/album.component';

export const routes: Routes = [
  { path: '', redirectTo: 'search', pathMatch: 'full' },
  { path: 'search', component: SearchComponent },
  { path: 'artists/:id', component: ArtistsComponent },
  { path: 'tracks/:id', component: TracksComponent },
  { path: 'albums/:id', component: AlbumComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
