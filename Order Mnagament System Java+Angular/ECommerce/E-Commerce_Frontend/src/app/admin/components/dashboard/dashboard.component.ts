import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NzButtonSize } from 'ng-zorro-antd/button';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AdminService } from '../../admin-services/admin.service';

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

  constructor(private adminService: AdminService,
    private notification: NzNotificationService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      title: [null, [Validators.required]],
    });
    // this.getAllCars();
  }

  submitForm() {
    this.isSpinning = true;
    this.products = [];
    this.adminService.getProductsByTitle(this.validateForm.get(['title'])!.value).subscribe((res) => {
      res.data.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,' + element.returnedImg;
        this.products.push(element);
        this.isSpinning = false;
      });
      console.log(res);
    });
  }




}
