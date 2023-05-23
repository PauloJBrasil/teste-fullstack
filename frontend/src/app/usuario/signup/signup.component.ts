import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiServices } from 'src/services/api-services.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  form = new FormGroup({
    name: new FormControl(null, Validators.required),
    username: new FormControl(null, Validators.required),
    password: new FormControl(null, Validators.required)
  })

  constructor(
    private apiService: ApiServices,
    private router: Router
    ) { }


  ngOnInit(): void {
  }

  signup() {
    if (this.form.invalid) {
      return
    }

    this.apiService.signup(this.form.get('name')?.value!, this.form.get('username')?.value!, this.form.get('password')?.value!).subscribe(
      response => {
        this.router.navigate(['/usuario/login'])
      }
    )
  }

}
