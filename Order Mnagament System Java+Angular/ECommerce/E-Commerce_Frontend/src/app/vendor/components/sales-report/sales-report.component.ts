import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzI18nService } from 'ng-zorro-antd/i18n';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { VendorService } from '../../services/vendor.service';

@Component({
  selector: 'app-sales-report',
  templateUrl: './sales-report.component.html',
  styleUrls: ['./sales-report.component.scss']
})
export class SalesReportComponent implements OnInit {

  myOrders: any[];
  listOfCategories: any = [];
  listOfProducts: any = [];
  date = null;
  validateForm!: FormGroup;
  dateFormat = 'yyyy-MM-dd';

  constructor(private fb: FormBuilder,
    private notification: NzNotificationService,
    private router: Router,
    private vendorService: VendorService,
    private i18n: NzI18nService,) { }


  ngOnInit(): void {
    this.validateForm = this.fb.group({
      startDate: [null, [Validators.required]],
      endDate: [null, [Validators.required]],
      categoryId: [null, [Validators.required]],
      productId: [null, [Validators.required]],
    });
    this.getAllCategories();
    this.getAllProducts();
  }

  getAllCategories() {
    this.vendorService.getAllCategories().subscribe((res) => {
      this.listOfCategories = res.data;
    })
  }

  getAllProducts() {
    this.vendorService.getAllProducts().subscribe((res) => {
      this.listOfProducts = res.data;
    })
  }

  
  getMyOrders() {
    this.vendorService.getMyOrders().subscribe((res) => {
      console.log(res);
      this.myOrders = res.data
    });
  }

}
