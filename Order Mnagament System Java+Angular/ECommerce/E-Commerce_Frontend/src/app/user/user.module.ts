import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { UserRoutingModule } from './user-routing.module';
import { UserComponent } from './user.component';
import { DemoNgZorroAntdModule } from '../DemoNgZorroAntdModule';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserDashboradComponent } from './components/user-dashborad/user-dashborad.component';
import { MyOrdersComponent } from './components/my-orders/my-orders.component';


@NgModule({
  declarations: [
    UserComponent,
    UserDashboradComponent,
    MyOrdersComponent,
  ],
  imports: [
    CommonModule,
    FormsModule,
    UserRoutingModule,
    DemoNgZorroAntdModule,
    ReactiveFormsModule
  ]
})
export class UserModule { }
