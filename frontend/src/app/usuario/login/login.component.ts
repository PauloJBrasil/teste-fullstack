import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from './../../../services/auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {

  constructor(
    private authService: AuthService,
    private router: Router
    ) { }

  form = new FormGroup({
    username: new FormControl(null, Validators.required),
    password: new FormControl(null, Validators.required)
  })
  isInvalid: boolean = false;

  ngOnInit(): void {
  }

  submitForm() {
    if (this.form.invalid) {
      return
    }

    this.authService.login(this.form.get('username')?.value!, this.form.get('password')?.value!).subscribe(
      response => {
        this.router.navigate(['/home'])
      },
      error => {
        this.form.controls['username'].setErrors({ 'incorrect': true })
        this.form.controls['password'].setErrors({ 'incorrect': true })
        this.isInvalid = true;
      }
    )
  }

}
