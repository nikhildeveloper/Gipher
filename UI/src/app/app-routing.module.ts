import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EntertainmentComponent } from './components/entertainment/entertainment.component';
import { GifsTrendComponent } from './components/gifs-trend/gifs-trend.component';
import { SportsComponent } from './components/sports/sports.component';
import { ReactionsComponent } from './components/reactions/reactions.component';
import { SearchGifComponent } from './components/search-gif/search-gif.component';
import{FavoritesComponent} from './components/favorites/favorites.component';
import{NavigationComponent} from './components/navigation/navigation.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ForgetPasswordComponent } from './components/forget-password/forget-password.component';
import { AuthGuard } from './services/authentication/auth.guard';
const routes: Routes = [
  {path:'Trending',component:GifsTrendComponent,canActivate:[AuthGuard]},
  {path:"Entertainment",component:EntertainmentComponent,canActivate:[AuthGuard]},
  {path:"Sports",component:SportsComponent,canActivate:[AuthGuard]},
  {path:"Reactions",component:ReactionsComponent,canActivate:[AuthGuard]},
  {path:"Searching",component:SearchGifComponent,canActivate:[AuthGuard]},
  {path:"Favorites",component:FavoritesComponent,canActivate:[AuthGuard]},
  {path:"login",component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"resetpassword",component:ForgetPasswordComponent},
  {path:"",redirectTo:'/login',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [EntertainmentComponent,RegisterComponent,LoginComponent,SportsComponent,GifsTrendComponent,ReactionsComponent,SearchGifComponent,FavoritesComponent,NavigationComponent];