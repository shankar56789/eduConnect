import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";


@Component(
    {
     selector:'app-course-create',
     templateUrl:'./coursecreate.component.html',
     styleUrls:['./coursecreate.component.scss']   
    }
)
export class CourseCreateComponent {
 
    courseForm:FormGroup;
    submitted=false;
    successMessage='';
    errorMessage='';
    constructor(private fb:FormBuilder)
    {
        this.courseForm=this.fb.group(
            {
                courseId:[0,Validators.required],
                courseName:['',Validators.required],
                description:['',[Validators.required,Validators.maxLength(500)]],
                teacherId:[null,[Validators.required,Validators.pattern(/^\d+$/)]]
              
            });
        
    }
    onSubmit():void
    {
        this.submitted=true;
        if(this.courseForm.valid)
{
    const course=this.courseForm.value;
    this.successMessage='Course created successfully!';
    this.errorMessage='';
    console.log('Course:',course);
}
else
{
    this.errorMessage='Please correct the errors in the form.';
    this.successMessage='';
}
}
resetForm():void
{
    this.courseForm.reset();
    this.submitted=false;
    this.successMessage='';
    this.errorMessage='';
}


}