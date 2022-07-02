import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { GiphyService } from './services/api/giphy.service';
import { AppRoutingModule,routingComponents } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import { GifsTrendComponent } from './components/gifs-trend/gifs-trend.component';
import { SearchGifComponent } from './components/search-gif/search-gif.component';
import { EntertainmentComponent } from './components/entertainment/entertainment.component';
import { ReactionsComponent } from './components/reactions/reactions.component';
import { SportsComponent } from './components/sports/sports.component';
import { NavigationComponent } from './components/navigation/navigation.component';
import { FavoritesComponent } from './components/favorites/favorites.component';
import { SctrendingComponent } from './components/sctrending/sctrending.component';
import { LoginComponent } from './components/login/login.component';
import{FormsModule} from '@angular/forms';
import { RegisterComponent } from './components/register/register.component';
import { ForgetPasswordComponent } from './components/forget-password/forget-password.component';
@NgModule({
  declarations: [
    AppComponent,
    GifsTrendComponent,
    SearchGifComponent,
    EntertainmentComponent,
    ReactionsComponent,
    SportsComponent,
    NavigationComponent,
    routingComponents,
    FavoritesComponent,
    SctrendingComponent,
    LoginComponent,
    RegisterComponent,
    ForgetPasswordComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [GiphyService],
  bootstrap: [AppComponent]
})
export class AppModule { }