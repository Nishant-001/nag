import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { VendorService } from '../../services/vendor.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.scss']
})
export class UpdateProductComponent implements OnInit {

  productId: any = this.activatedroute.snapshot.params['productId'];
  currentFileUpload: File;
  myFile: FileList;
  avatarUrl: any = 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMEOb9DSnnU_mwSu5HYXuFuUjktAvKecyMrw&usqp=CAU';
  validateForm!: FormGroup;
  imgChanged = false;
  listOfCategories: any = [];

  constructor(private fb: FormBuilder,
    private notification: NzNotificationService,
    private router: Router,
    private vendorService: VendorService,
    private activatedroute: ActivatedRoute,) { }

  ngOnInit(): void {
    this.validateForm = this.fb.group({

      categoryId: [null, [Validators.required]],
      name: [null, [Validators.required]],
      code: [null, [Validators.required]],
      discount: [null, [Validators.required]],
      description: [null, [Validators.required]],
      price: [null, [Validators.required]],
    });
    this.getProductById();
    this.getAllCategories();
  }

  getProductById() {
    this.vendorService.getProductById(this.productId).subscribe((res) => {
      console.log(res);
      const productDto = res.data.productDto;
      
      this.avatarUrl = 'data:image/jpeg;base64,' + res.data.productDto.returnedImg;
      this.validateForm.patchValue(productDto);
    })
  }

  getAllCategories() {
    this.vendorService.getAllCategories().subscribe((res) => {
      this.listOfCategories = res.data;
    })
  }

  submitForm(): void {
    console.log(this.validateForm.valid);
    console.log(this.validateForm);
    if (this.validateForm.valid) {
      console.log("In function");
      const formData: FormData = new FormData();
      if (this.imgChanged) {
        formData.append('img', this.currentFileUpload);
      }
      formData.append('categoryId', this.validateForm.get('categoryId').value);
      formData.append('name', this.validateForm.get('name').value);
      formData.append('code', this.validateForm.get('code').value);
      formData.append('price', this.validateForm.get('price').value);
      formData.append('discount', this.validateForm.get('discount').value);
      formData.append('description', this.validateForm.get('description').value);
      console.log(formData);
      
      this.vendorService.updateProduct(this.productId, formData).subscribe((res) => {
        if (res.status == "OK") {
          this.notification
            .success(
              'SUCCESS',
              `Product updated Successfully!`,
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

  uploadProfileImage(event: Event) {
    const input = event.target as HTMLInputElement;
    if (!input.files?.length) {
      return;
    }
    const file = input.files[0];
    this.currentFileUpload = file;
    alert('File is here : ' + this.currentFileUpload);

  }

  public uploadFile(event: Event): void {
    const input = event.target as HTMLInputElement;
    this.myFile = input.files;

    if (!input.files?.length) {
      return;
    }
    this.currentFileUpload = input.files[0];
    var reader = new FileReader();
    reader.readAsDataURL(this.currentFileUpload);
    this.imgChanged = true;
    reader.onload = (_event) => {
      this.avatarUrl = reader.result;
    };
  }

  getCaptcha(e: MouseEvent): void {
    e.preventDefault();
  }

}
