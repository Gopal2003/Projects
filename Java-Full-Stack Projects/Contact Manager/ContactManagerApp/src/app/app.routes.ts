import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { UserComponent } from './user/user.component';
import { ContactComponent } from './contact/contact.component';

export const routes: Routes = [{path:"login",component: LoginComponent},{path:"signup",component: UserComponent},{path:"contact",component: ContactComponent}];