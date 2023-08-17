import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VendorRoutingModule } from './vendor-routing.module';
import { VendorComponent } from './vendor.component';
import { DemoNgZorroAntdModule } from '../DemoNgZorroAntdModule';
import { UpdateProductComponent } from './components/update-product/update-product.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CategoryComponent } from './components/category/category.component';
import { ProductComponent } from './components/product/product.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SalesReportComponent } from './components/sales-report/sales-report.component';


@NgModule({
  declarations: [
    VendorComponent,
    UpdateProductComponent,
    DashboardComponent,
    CategoryComponent,
    ProductComponent,
    SalesReportComponent
  ],
  imports: [
    CommonModule,
    VendorRoutingModule,
    DemoNgZorroAntdModule,
    ReactiveFormsModule
  ]
})
export class VendorModule { }
