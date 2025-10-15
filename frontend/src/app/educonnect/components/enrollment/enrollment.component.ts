import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";


@Component(
    {
     selector:'app-enrollment',
     templateUrl:'./enrollment.component.html',
     styleUrls:['./enrollment.component.scss']   
    }
)

export class EnrollmentComponent {

    enrollmentForm:FormGroup;
    successMessage='';
    errorMessage='';
    constructor(private fb:FormBuilder)
    {
        this.enrollmentForm=this.fb.group(
            {
                enrollmentId:[null],
                studentId:[null,[Validators.required,Validators.pattern('^[0-9]+$')]],
                courseId:[null,[Validators.required,Validators.pattern('^[0-9]+$')]],
                    enrollmentDate:[null,[Validators.required]]
              
            });
        }
            onSubmit():void
            {
           if(this.enrollmentForm.valid)
           {
                this.successMessage='Enrollment saved successfully!';
                this.errorMessage='';
            }
            else
            {
                this.errorMessage='Please correct the errors in the form.';
                this.successMessage='';
            }
            }

            resetForm():void
{
    this.enrollmentForm.reset({
   // this.submitted=false;
   // this.submitted=false;
        enrollmentId: null,
        studentId:null,
        courseId:null,
        enrollmentDate:null
    })
    this.successMessage='';
    this.errorMessage='';


}
    }