import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AdminDashboardComponent } from './components/admin/admin-dashboard/admin-dashboard.component';
import { TechnicianDashboardComponent } from './components/technician/technician-dashboard/technician-dashboard.component';
import { UserDashboardComponent } from './components/user/user-dashboard/user-dashboard.component';
import {HttpClientModule, provideHttpClient, withFetch} from "@angular/common/http";
import { AddEquipementComponent } from './components/equipement/add-equipement/add-equipement.component';
import { EditEquipementComponent } from './components/equipement/edit-equipement/edit-equipement.component';
import { EquipementPageComponent } from './components/equipement/equipement-page/equipement-page.component';
import { AddUtilisateurComponent } from './components/utilisateurs/add-utilisateur/add-utilisateur.component';
import {ListUtilisateurComponent} from "./components/utilisateurs/list-utilisateur/list-utilisateur.component";
import {ListEquipementComponent} from "./components/equipement/list-equipement/list-equipement.component";
import { UserPageComponent } from './components/utilisateurs/user-page/user-page.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AdminDashboardComponent,
    TechnicianDashboardComponent,
    UserDashboardComponent,
    AddEquipementComponent,
    ListEquipementComponent,
    EditEquipementComponent,
    EquipementPageComponent,
    AddUtilisateurComponent,
    ListUtilisateurComponent,
    UserPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    provideHttpClient(withFetch())
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
