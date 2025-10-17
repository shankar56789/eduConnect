import { Component } from '@angular/core';
import { Teacher } from '../../models/Teacher';

@Component({
  selector: 'teacher-sample',
  templateUrl: './teachersample.component.html',
  styleUrls: ['./teachersample.component.scss'],
  standalone: true
})
export class TeacherSampleComponent  {
    teacher:Teacher;
    constructor(){
      this.teacher=new Teacher(1,"abc","9876543210","abc@gmail.com","Science",50);
    }
    logStudentDetails():void
    {
      console.log("teacher:",this.teacher);
    }
  
}
