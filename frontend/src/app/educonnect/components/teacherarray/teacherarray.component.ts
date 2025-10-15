import { Component, NgModule } from "@angular/core";
import { Teacher } from "../../models/Teacher";
import {CommonModule} from '@angular/common';
import { NgModel } from "@angular/forms";

@NgModule(
    {
        declarations:[TeacherArrayComponent],
        imports:[CommonModule],
    }
)
@Component(
    {
        selector:"teacher-root",
        templateUrl:"./teacherarray.component.html",
        styleUrls:["./teacherarray.component.scss"]
    }
)
export class TeacherArrayComponent  {
    
    showDetails:boolean=false;
    teachers:Teacher[]=[new Teacher(1,'Jane smith','9876554445','akice@gmail.com','mh',5),
            new Teacher(2,'Bob','9876554445','aice@gmail.com','math',5)];
    // constructor()
    // {
    //     this.teachers=[new Teacher(1,'Alice','9876554445','akice@gmail.com','mh',5),
    //     new Teacher(2,'Bob','9876554445','aice@gmail.com','math',5)
    //     ];
    // }
   constructor()
   {

   }
   toogleDetails():void
   {
    this.showDetails=!this.showDetails;
   }

 

}
