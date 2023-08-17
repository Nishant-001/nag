import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { VendorService } from '../../services/vendor.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.scss']
})
export class CategoryComponent implements OnInit {

  validateForm!: FormGroup;

  constructor(private fb: FormBuilder,
    private notification: NzNotificationService,
    private router: Router,
    private vendorService: VendorService) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      name: [null, [Validators.required]],
      description: [null, [Validators.required]],
    });
  }


  submitForm(): void {
    console.log(this.validateForm.valid);
    console.log(this.validateForm);
    if (this.validateForm.valid) {
      console.log("In function");
      this.vendorService.addCategory(this.validateForm.value).subscribe((res) => {
        if (res.status == "CREATED") {
          this.notification
            .success(
              'SUCCESS',
              `Category Posted Successfully!!!`,
              { nzDuration: 5000 }
            );
          this.router.navigateByUrl('/admin/dashboard');
        } else {
          this.notification
            .error(
              'ERROR',
              `${res.message}`,
              { nzDuration: 5000 }
            )
        }
      });
    } else {
      for (const i in this.validateForm.controls) {
        this.validateForm.controls[i].markAsDirty();
        this.validateForm.controls[i].updateValueAndValidity();
      }
    }
  }

}

