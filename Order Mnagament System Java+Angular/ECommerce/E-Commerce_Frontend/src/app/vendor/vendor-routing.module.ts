import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import { CategoryComponent } from './components/category/category.component';
import { ProductComponent } from './components/product/product.component';
import { UpdateProductComponent } from './components/update-product/update-product.component';
import { AuthVendorGuard } from '../guards/authVendor/auth-vendor.guard';
import { SalesReportComponent } from './components/sales-report/sales-report.component';

const routes: Routes = [

  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthVendorGuard] },
  { path: 'category', component: CategoryComponent, canActivate: [AuthVendorGuard] },
  { path: 'product', component: ProductComponent, canActivate: [AuthVendorGuard] },
  { path: 'product/:productId', component: UpdateProductComponent, canActivate: [AuthVendorGuard] },
  { path: 'sales-port', component: SalesReportComponent, canActivate: [AuthVendorGuard] },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VendorRoutingModule { }
