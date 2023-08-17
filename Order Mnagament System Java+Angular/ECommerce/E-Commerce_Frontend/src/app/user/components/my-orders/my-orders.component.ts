import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { NzButtonSize } from 'ng-zorro-antd/button';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { UserService } from '../../user-services/user.service';

@Component({
  selector: 'app-my-orders',
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.scss']
})
export class MyOrdersComponent implements OnInit {

  myOrders: any[];
  validateForm!: FormGroup;
  size: NzButtonSize = 'large';

  constructor(private userService: UserService,
    private notification: NzNotificationService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.getMyOrders();
  }

  getMyOrders() {
    this.userService.getMyOrders().subscribe((res) => {
      console.log(res);
      this.myOrders = res.data
    });
  }

}
