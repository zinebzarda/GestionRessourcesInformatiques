import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { AdminDashboardComponent } from './components/admin/admin-dashboard/admin-dashboard.component';
import { TechnicianDashboardComponent } from './components/technician/technician-dashboard/technician-dashboard.component';
import { UserDashboardComponent } from './components/user/user-dashboard/user-dashboard.component';
import {EquipementPageComponent} from "./components/equipement/equipement-page/equipement-page.component";
import {UserPageComponent} from "./components/utilisateurs/user-page/user-page.component";
import {TicketPageComponent} from "./components/tickets/ticket-page/ticket-page.component";
import {AddTicketComponent} from "./components/tickets/add-ticket/add-ticket.component";
import {UserTicketPageComponent} from "./components/user/user-ticket-page/user-ticket-page.component";

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch: 'full' },

  { path: 'admin-dashboard', component: AdminDashboardComponent, children:[
      { path: '', component: EquipementPageComponent },
      { path: 'User-page', component: UserPageComponent },
      { path: 'Ticket-page', component: TicketPageComponent },
      { path: 'admin-dashboard/edit-ticket/:id', component: EquipementPageComponent },

      ]},
  { path: 'technician-dashboard', component: TechnicianDashboardComponent },

  { path: 'user-dashboard', component: UserDashboardComponent, children:[
      { path: '', component: UserTicketPageComponent },
    ] },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }




