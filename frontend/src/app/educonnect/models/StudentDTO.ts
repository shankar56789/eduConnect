export class StudentDTO {



    studnetId:number;
    username:string;
    password:string;
    fullName:string;
    dateOfBirth:Date;
    contactNumber:string;
    email:string;
    address:string;
    constructor(studentId:number,username:string,password:string,fullName:string,dateOfBirth:Date,contactNumber:string,email:string,address:string)
    {
        this.studnetId=studentId;
        this.username=username;
        this.password=password;
        this.fullName=fullName;
        this.dateOfBirth=dateOfBirth;
        this.contactNumber=contactNumber;
        this.email=email;
        this.address=address;

    }

}
