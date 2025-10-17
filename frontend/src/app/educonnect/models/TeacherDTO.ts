
export class TeacherDTO {
    teacherId:number;
    username:string;
    password:string;
    fullname:string;
    contactNumber:string;
    email:string;
    speciality:string;
    yearsOfExperience:number;
    constructor(teacherId:number,username:string,password:string,fullName:string,contactNumber:string,email:string,speciality:string,yearsOfExperience:number){
        this.teacherId=teacherId;
        this.username=username;
        this.password=password;
        this.fullname=fullName;
        this.contactNumber=contactNumber;
        this.email=email;
        this.speciality=speciality;
        this.yearsOfExperience=yearsOfExperience;
    }
 

}