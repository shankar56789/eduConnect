import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";


@Component(
    {
     selector:'app-teacher-create',
     templateUrl:'./teachercreate.component.html',
     styleUrls:['./teachercreate.component.scss']   
    }
)
export class TeacherCreateComponent {
    teacherForm:FormGroup;
    submitted=false;
    successMessage='';
    errorMessage='';
    constructor(private fb:FormBuilder)
    {
        this.teacherForm=this.fb.group(
            {
                teacherId:[0,Validators.required],
                fullName:['',Validators.required],
                contactNumber:['',[Validators.required,Validators.pattern(/^\d{10}$/)]],
                email:['',[Validators.required,Validators.email]],
                subject:['',Validators.required],
                yearsOfExperience:[0,[Validators.required,Validators.min(0)]]
            });
        
    }
    onSubmit():void
    {
        this.submitted=true;
        if(this.teacherForm.valid)
{
    const teacher=this.teacherForm.value;
    this.successMessage='Teacher created successfully!';
    this.errorMessage='';
    console.log('Teacher:',teacher);
}
else
{
    this.errorMessage='Please correct the errors in the form.';
    this.successMessage='';
}
    }
    resetForm():void
    {
        this.teacherForm.reset();
        this.submitted=false;
        this.successMessage='';
        this.errorMessage='';
    }


}