import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { NzButtonSize } from 'ng-zorro-antd/button';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { UserService } from '../../user-services/user.service';

@Component({
  selector: 'app-user-dashborad',
  templateUrl: './user-dashborad.component.html',
  styleUrls: ['./user-dashborad.component.scss']
})
export class UserDashboradComponent implements OnInit {

  products: any = [];
  validateForm!: FormGroup;
  size: NzButtonSize = 'large';

  constructor(private userService: UserService,
    private notification: NzNotificationService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      title: [null, [Validators.required]],
    });
    this.getAllProducts();
  }

  submitForm() {
    this.products = [];
    this.userService.getProductsByTitle(this.validateForm.get(['title'])!.value).subscribe((res) => {
      res.data.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,' + element.returnedImg;
        this.products.push(element);
      });
      console.log(res);
    });
  }

  getAllProducts() {
    this.products = [];
    this.userService.getAllProducts().subscribe((res) => {
      res.data.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,' + element.returnedImg;
        this.products.push(element);
      });
      console.log(res);
    });
  }

  buy(productId: any) {
    this.userService.buyProduct(productId).subscribe((res) => {
      if (res.status == "CREATED") {
        this.notification
          .success(
            'SUCCESS',
            `Order placed Successfully!`,
            { nzDuration: 1000 }
          );
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
