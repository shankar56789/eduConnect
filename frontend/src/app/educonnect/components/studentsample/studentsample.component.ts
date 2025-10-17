import { Component } from '@angular/core';
import { Student } from '../../models/Student';

@Component({
  selector: 'student-sample',
  templateUrl: './studentsample.component.html',
  styleUrls: ['./studentsample.component.scss'],
  standalone: true
})
export class StudentSampleComponent {
    student:Student;
  constructor(){
    this.student=new Student(1,"abc",new Date("2025-12-12"),"9876543210","abc@gmail.com","abcd");
  }
  logStudentAttributes()
  {
    console.log("student:",this.student);
  }
}
