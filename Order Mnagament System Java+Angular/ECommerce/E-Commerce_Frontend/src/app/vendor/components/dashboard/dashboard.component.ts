import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzButtonSize } from 'ng-zorro-antd/button';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { VendorService } from '../../services/vendor.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  products: any = [];
  validateForm!: FormGroup;
  blogs: any;
  searchBlogByTitle: any;
  isSpinning = false;
  size: NzButtonSize = 'large';

  constructor(private vendorService: VendorService,
    private notification: NzNotificationService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      title: [null, [Validators.required]],
    });
    this.getAllProducts();
  }

  submitForm() {
    this.isSpinning = true;
    this.products = [];
    this.vendorService.getProductsByTitle(this.validateForm.get(['title'])!.value).subscribe((res) => {
      res.data.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,' + element.returnedImg;
        this.products.push(element);
        this.isSpinning = false;
      });
      // this.cars=res.data
      console.log(res);
    });
  }

  getAllProducts() {
    this.isSpinning = true;
    this.products = [];
    this.vendorService.getAllProducts().subscribe((res) => {
      res.data.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,' + element.returnedImg;
        this.products.push(element);
        this.isSpinning = false;
      });
      // this.cars=res.data
      console.log(res);
    });
  }



  deleteProduct(productId: any) {
    this.vendorService.deleteProductById(productId).subscribe((res) => {
      if (res.status == "OK") {
        this.notification
          .success(
            'SUCCESS',
            `Product Deleted Successfully!!!`,
            { nzDuration: 5000 }
          );
          location.reload();
      } else {
        this.notification
          .error(
            'ERROR',
            `${res.message}`,
            { nzDuration: 5000 }
          )
      }
    });
  }

}
