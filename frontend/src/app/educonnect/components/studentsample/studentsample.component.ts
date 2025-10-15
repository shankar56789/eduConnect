import { Component } from '@angular/core';
import { Student } from '../../models/Student';

@Component({
  selector: 'student-root',
  templateUrl: './studentsample.component.html',
  styleUrls: ['./studentsample.component.scss'],
  standalone:true
})
export class StudentSampleComponent {

    student:Student;
    constructor()
    {

        this.student=new Student(1,"abc",new Date("2025-04-09"),"902903993","a@gmail.com","abcde");
        

    }
  logStudentDetails()
  {
    console.log("student:",this.student);
  }
}
