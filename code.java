import java.util.*;
interface Global
{
    List<Integer> patient_id=new ArrayList<Integer>();
    List<String> patient_name=new ArrayList<String>();
    List<Integer> patient_phno=new ArrayList<Integer>();
    List<String> patient_problem=new ArrayList<String>();
    List<Integer> patient_dep_id=new ArrayList<Integer>();
    List<String> joined_date=new ArrayList<String>();
    List<String> discharged_date=new ArrayList<String>();
    List<Integer> discharge=new ArrayList<Integer>();
    List<Integer> department_id=new ArrayList<Integer>();
    List<String> department_name=new ArrayList<String>();
    List<Integer> doctor_id=new ArrayList<Integer>();
    List<String> doctor_name=new ArrayList<String>();
    List<Integer> doctor_dep_id=new ArrayList<Integer>();
    List<Integer> number_of_patients=new ArrayList<Integer>();
    List<Integer> patients_bill=new ArrayList<Integer>();
}
class Management implements Global
{
   
   
    public void Department()
    {
        Scanner c=new Scanner(System.in);
        System.out.println("Enter New Department Id:");
        int id=c.nextInt();
        System.out.println("Enter New Department Name:");
        String name=c.nextLine();
       
        department_id.add(id);
        department_name.add(name);
    }
    public void Doctor()
    {
        Scanner c=new Scanner(System.in);
        System.out.println("Enter New Doctor ID");
        int id=c.nextInt();
        System.out.println("Enter Doctor Name");
        String name=c.nextLine();
        System.out.println("Enter Doctor Department ID");
        int dep_id=c.nextInt();
        int no_of_pat=0;
       
        doctor_id.add(id);
        doctor_name.add(name);
        doctor_dep_id.add(dep_id);
        number_of_patients.add(no_of_pat);
    }
    public void Patient()
    {
        Scanner c=new Scanner(System.in);
        System.out.println("Enter New Patient Id:");
        int id=c.nextInt();
        System.out.println("Enter Patient Name:");
        String name=c.nextLine();
        System.out.println("Enter Phone Number:");
        int phno=c.nextInt();
        System.out.println("Enter Patients Problem:");
        String problem=c.nextLine();
        System.out.println("Enter Patients Department Id:");
        int dep_id=c.nextInt();
        System.out.println("Enter Patients Joining Date:");
        String date=c.nextLine();
        int dis=0;
        int bill=0;
       
        patient_id.add(id);
        patient_name.add(name);
        patient_phno.add(phno);
        patient_problem.add(problem);
        patient_dep_id.add(dep_id);
        joined_date.add(date);
        discharge.add(dis);
        patients_bill.add(bill);
    }
    public void Patient_discharge()
    {
        Scanner c=new Scanner(System.in);
        System.out.println("Enter Patients Id:");
        int id=c.nextInt();
        System.out.println("Enter Patients Discharge Date:");
        String date=c.nextLine();
        int size = patient_id.size();
        for(int i=0;i<size;i++)
        {
            if(id==patient_id.get(i))
            {
                discharge.set(i,1);
                discharged_date.add(date);
            }
        }
    }
}

public class Hospital implements Global
{
    /**
     * @param args
     */
    public static void main (String[] args)
    {
        Management m=new Management();
        System.out.println("Hospital Management System");
        int a=1;
        int size;
        while(a==1)
        {
            Scanner s=new Scanner(System.in);
            System.out.println("1.Doctor\n2.Patient\n3.Department\n4.Exit");
            System.out.print("Enter your choice:");
            int choice=s.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("1.New Doctor\n2.Search Doctor");
                    System.out.print("Enter your choice:");
                    choice=s.nextInt();
                    switch(choice)
                    {
                        case 1:
                            m.Doctor();
                            break;
                        case 2:
                            System.out.println("1.Doctor Id\n2.Doctor Name");
                            System.out.print("Enter your choice:");
                            choice=s.nextInt();
                            switch(choice)
                            {
                                case 1:
                                    System.out.println("Enter Doctor ID:");
                                    int id=s.nextInt();
                                    size = doctor_id.size();
                                    for(int i=0;i<size;i++)
                                    {
                                        if(id==doctor_id.get(i))
                                        {
                                            System.out.println("Doctor Id:"+doctor_id.get(i));
                                            System.out.println("Doctor Name:"+doctor_name.get(i));
                                            System.out.println("Doctor Department Id:"+doctor_dep_id.get(i));
                                            System.out.println("Number of Patients:"+number_of_patients.get(i));
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("Enter Doctor Name:");
                                    System.out.print("Enter your choice:");
                                    String name=s.nextLine();
                                    size = doctor_name.size();
                                    for(int i=0;i<size;i++)
                                    {
                                        if(name==doctor_name.get(i))
                                        {
                                            System.out.println("Doctor Id:"+doctor_id.get(i));
                                            System.out.println("Doctor Name:"+doctor_name.get(i));
                                            System.out.println("Doctor Department Id:"+doctor_dep_id.get(i));
                                            System.out.println("Number of Patients:"+number_of_patients.get(i));
                                        }
                                    }
                                    break;
                                default:System.out.println("Choose valid option");
                            }
                            break;
                        default:System.out.println("Choose valid option");
                    }
                    break;
                case 2:
                    System.out.println("1.New Patient\n2.Active Patients\n3.Discharged Patients");
                    System.out.print("Enter your choice:");
                    choice=s.nextInt();
                    switch(choice)
                    {
                        case 1:
                            m.Patient();
                            break;
                        case 2:
                            System.out.println("1.Number of Active Patients\n2.Search Patient");
                            System.out.print("Enter your choice:");
                            choice=s.nextInt();
                            switch(choice)
                            {
                                case 1:
                                    size = patient_id.size();
                                    for(int i=0;i<size;i++)
                                    {
                                        if(discharge.get(i)==0)
                                        {
                                            System.out.println("Patient Id:"+patient_id.get(i));
                                            System.out.println("Patient Name:"+patient_name.get(i));
                                            System.out.println("Patient Phone Number:"+patient_phno);
                                            System.out.println("Patient Problem:"+patient_problem);
                                            System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                            System.out.println("Patient Joined Date:"+joined_date.get(i));
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("1.PatientId\n2.Patient Name\n3.Patient Joined Date");
                                    System.out.print("Enter your choice:");
                                    choice=s.nextInt();
                                    switch(choice)
                                    {
                                        case 1:
                                            System.out.println("Enter Patient ID:");
                                            int id=s.nextInt();
                                            size = patient_id.size();
                                            for(int i=0;i<size;i++)
                                            {
                                                if(id==patient_id.get(i) && discharge.get(i)==0)
                                                {
                                                    System.out.println("Patient Id:"+patient_id.get(i));
                                                    System.out.println("Patient Name:"+patient_name.get(i));
                                                    System.out.println("Patient Phone Number:"+patient_phno);
                                                    System.out.println("Patient Problem:"+patient_problem);
                                                    System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                    System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Enter Patient Name:");
                                            String name=s.nextLine();
                                            size = patient_name.size();
                                            for(int i=0;i<size;i++)
                                            {
                                                if(name==patient_name.get(i) && discharge.get(i)==0)
                                                {
                                                    System.out.println("Patient Id:"+patient_id.get(i));
                                                    System.out.println("Patient Name:"+patient_name.get(i));
                                                    System.out.println("Patient Phone Number:"+patient_phno);
                                                    System.out.println("Patient Problem:"+patient_problem);
                                                    System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                    System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Enter Patient Joined Date:");
                                            String date=s.nextLine();
                                            size = joined_date.size();
                                            for(int i=0;i<size;i++)
                                            {
                                                if(date==joined_date.get(i) && discharge.get(i)==0)
                                                {
                                                    System.out.println("Patient Id:"+patient_id.get(i));
                                                    System.out.println("Patient Name:"+patient_name.get(i));
                                                    System.out.println("Patient Phone Number:"+patient_phno);
                                                    System.out.println("Patient Problem:"+patient_problem);
                                                    System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                    System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                }
                                            }
                                            break;
                                        default:System.out.println("Choose valid option");
                                    }
                                    break;
                                default:System.out.println("Choose valid option");
                            }
                            break;
                        case 3:
                            System.out.println("1.Number of Discharged Patients\n2.Search Patient");
                            System.out.print("Enter your choice:");
                            choice=s.nextInt();
                            switch(choice)
                            {
                                case 1:
                                    size = patient_id.size();
                                    for(int i=0;i<size;i++)
                                    {
                                        if(discharge.get(i)==1)
                                        {
                                            System.out.println("Patient Id:"+patient_id.get(i));
                                            System.out.println("Patient Name:"+patient_name.get(i));
                                            System.out.println("Patient Phone Number:"+patient_phno);
                                            System.out.println("Patient Problem:"+patient_problem);
                                            System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                            System.out.println("Patient Joined Date:"+joined_date.get(i));
                                        }
                                    }
                                    break;
                                case 2:
                                    System.out.println("1.Patient Id\n2.Patient Name\n3.Patient Joined Date\n4.Patient Discharged Date");
                                    System.out.print("Enter your choice:");
                                    choice=s.nextInt();
                                    switch(choice)
                                    {
                                        case 1:
                                            System.out.println("Enter Patient ID:");
                                            int id=s.nextInt();
                                            size = patient_id.size();
                                            for(int i=0;i<size;i++)
                                            {
                                                if(id==patient_id.get(i) && discharge.get(i)==1)
                                                {
                                                    System.out.println("Patient Id:"+patient_id.get(i));
                                                    System.out.println("Patient Name:"+patient_name.get(i));
                                                    System.out.println("Patient Phone Number:"+patient_phno);
                                                    System.out.println("Patient Problem:"+patient_problem);
                                                    System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                    System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                }
                                            }
                                            break;
                                        case 2:
                                            System.out.println("Enter Patient Name:");
                                            String name=s.nextLine();
                                            size = patient_name.size();
                                            for(int i=0;i<size;i++)
                                            {
                                                if(name==patient_name.get(i) && discharge.get(i)==1)
                                                {
                                                    System.out.println("Patient Id:"+patient_id.get(i));
                                                    System.out.println("Patient Name:"+patient_name.get(i));
                                                    System.out.println("Patient Phone Number:"+patient_phno);
                                                    System.out.println("Patient Problem:"+patient_problem);
                                                    System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                    System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("Enter Patient Joines Date:");
                                            String date=s.nextLine();
                                            size = joined_date.size();
                                            for(int i=0;i<size;i++)
                                            {
                                                if(date==joined_date.get(i) && discharge.get(i)==1)
                                                {
                                                    System.out.println("Patient Id:"+patient_id.get(i));
                                                    System.out.println("Patient Name:"+patient_name.get(i));
                                                    System.out.println("Patient Phone Number:"+patient_phno);
                                                    System.out.println("Patient Problem:"+patient_problem);
                                                    System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                    System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                }
                                            }
                                            break;
                                        case 4:
                                            System.out.println("Enter Patient Joines Date:");
                                            String d=s.nextLine();
                                            size = discharged_date.size();
                                            for(int i=0;i<size;i++)
                                            {
                                                if(d==joined_date.get(i) && discharge.get(i)==1)
                                                {
                                                    System.out.println("Patient Id:"+patient_id.get(i));
                                                    System.out.println("Patient Name:"+patient_name.get(i));
                                                    System.out.println("Patient Phone Number:"+patient_phno);
                                                    System.out.println("Patient Problem:"+patient_problem);
                                                    System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                    System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                    System.out.println("Patient Discharged Date:"+discharged_date.get(i));
                                                }
                                            }
                                            break;
                                        default:System.out.println("Choose valid option");
                                    }
                                    break;
                                default:System.out.println("Choose valid option");
                            }
                            break;
                        default:System.out.println("Choose valid option");
                    }
                    break;
                case 3:
                    System.out.println("1.New Department\n2.All Departments\n3.Search Department");
                    System.out.print("Enter your choice:");
                    choice=s.nextInt();
                    switch(choice)
                    {
                        case 1:
                            m.Department();
                            break;
                        case 2:
                            size=department_id.size();
                            for(int i=0;i<size;i++)
                            {
                                System.out.println("Department ID:"+department_id.get(i));
                                System.out.println("Department Name:"+department_name.get(i));
                                int count1=0;
                                for(int j=0;j<doctor_id.size();j++)
                                {
                                    if(doctor_dep_id.get(j)==department_id.get(i))
                                    {
                                        count1+=1;
                                    }
                                }
                                System.out.println("Number of Doctors in department:"+count1);
                                int count2=0;
                                for(int j=0;j<patient_id.size();j++)
                                {
                                    if(patient_dep_id.get(j)==department_id.get(i))
                                    {
                                        count2+=1;
                                    }
                                }
                                System.out.println("Number of Patients in department:"+count2);
                            }
                            break;
                        case 3:
                            System.out.println("1.Department ID\n2.Department Name");
                            System.out.print("Enter your choice:");
                            choice=s.nextInt();
                            switch(choice)
                            {
                                case 1:
                                    System.out.println("Enter Department ID:");
                                    int id=s.nextInt();
                                    System.out.println("1.Department Doctors\n2.Department Patients\n3.Search Doctor\n4.Search Patient");
                                    System.out.print("Enter your choice:");
                                    choice=s.nextInt();
                                    switch(choice)
                                    {
                                        case 1:
                                            for(int i=0;i<doctor_id.size();i++)
                                            {
                                                if(doctor_dep_id.get(i)==id)
                                                {
                                                    System.out.println("Doctor Id:"+doctor_id.get(i));
                                                    System.out.println("Doctor Name:"+doctor_name.get(i));
                                                    System.out.println("Doctor Department Id:"+doctor_dep_id.get(i));
                                                    System.out.println("Number of Patients:"+number_of_patients.get(i));
                                                }
                                            }
                                            break;
                                        case 2:
                                            for(int i=0;i<patient_id.size();i++)
                                            {
                                                if(patient_dep_id.get(i)==id)
                                                {
                                                    System.out.println("Patient Id:"+patient_id.get(i));
                                                    System.out.println("Patient Name:"+patient_name.get(i));
                                                    System.out.println("Patient Phone Number:"+patient_phno);
                                                    System.out.println("Patient Problem:"+patient_problem);
                                                    System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                    System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("1.Doctor Id\n2.Doctor Name");
                                            System.out.print("Enter your choice:");
                                            choice=s.nextInt();
                                            switch(choice)
                                            {
                                                case 1:
                                                    System.out.println("Enter Doctor ID:");
                                                    int doc_id=s.nextInt();
                                                    for(int i=0;i<doctor_id.size();i++)
                                                    {
                                                        if(doctor_dep_id.get(i)==id && doctor_id.get(i)==doc_id);
                                                        {
                                                            System.out.println("Doctor Id:"+doctor_id.get(i));
                                                            System.out.println("Doctor Name:"+doctor_name.get(i));
                                                            System.out.println("Doctor Department Id:"+doctor_dep_id.get(i));
                                                            System.out.println("Number of Patients:"+number_of_patients.get(i));
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Enter Doctor Name:");
                                                    String doc_name=s.nextLine();
                                                    for(int i=0;i<doctor_id.size();i++)
                                                    {
                                                        if(doctor_dep_id.get(i)==id && doctor_name.get(i)==doc_name);
                                                        {
                                                            System.out.println("Doctor Id:"+doctor_id.get(i));
                                                            System.out.println("Doctor Name:"+doctor_name.get(i));
                                                            System.out.println("Doctor Department Id:"+doctor_dep_id.get(i));
                                                            System.out.println("Number of Patients:"+number_of_patients.get(i));
                                                        }
                                                    }
                                                    break;
                                                default:System.out.println("Choose valid option");
                                            }
                                            break;
                                        case 4:
                                            System.out.println("1.Patient Id\n2.Patient Name\n3.Patient Joined Date");
                                            System.out.print("Enter your choice:");
                                            choice=s.nextInt();
                                            switch(choice)
                                            {
                                                case 1:
                                                    System.out.println("Enter Patient ID:");
                                                    int pat_id=s.nextInt();
                                                    for(int i=0;i<patient_id.size();i++)
                                                    {
                                                        if(patient_dep_id.get(i)==id && patient_id.get(i)==pat_id);
                                                        {
                                                            System.out.println("Patient Id:"+patient_id.get(i));
                                                            System.out.println("Patient Name:"+patient_name.get(i));
                                                            System.out.println("Patient Phone Number:"+patient_phno);
                                                            System.out.println("Patient Problem:"+patient_problem);
                                                            System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                            System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Enter Patient Name:");
                                                    String pat_name=s.nextLine();
                                                    for(int i=0;i<patient_name.size();i++)
                                                    {
                                                        if(patient_dep_id.get(i)==id && patient_name.get(i)==pat_name);
                                                        {
                                                            System.out.println("Patient Id:"+patient_id.get(i));
                                                            System.out.println("Patient Name:"+patient_name.get(i));
                                                            System.out.println("Patient Phone Number:"+patient_phno);
                                                            System.out.println("Patient Problem:"+patient_problem);
                                                            System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                            System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Enter Patient Joined Date:");
                                                    String da=s.nextLine();
                                                    for(int i=0;i<joined_date.size();i++)
                                                    {
                                                        if(patient_dep_id.get(i)==id && joined_date.get(i)==da);
                                                        {
                                                            System.out.println("Patient Id:"+patient_id.get(i));
                                                            System.out.println("Patient Name:"+patient_name.get(i));
                                                            System.out.println("Patient Phone Number:"+patient_phno);
                                                            System.out.println("Patient Problem:"+patient_problem);
                                                            System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                            System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                        }
                                                    }
                                                    break;
                                                default:System.out.println("Choose valid option");
                                            }
                                            break;
                                        default:System.out.println("Choose valid option");
                                    }
                                    break;
                                case 2:
                                    System.out.println("Enter Department Name:");
                                    String name=s.nextLine();
                                    System.out.println("1.Department Doctors\n2.Department Patients\n3.Search Doctor\n4.Search Patient");
                                    System.out.print("Enter your choice:");
                                    choice=s.nextInt();
                                    switch(choice)
                                    {
                                        case 1:
                                            for(int i=0;i<doctor_name.size();i++)
                                            {
                                                if(department_name.get(i)==name && doctor_dep_id.get(i)==department_id.get(i))
                                                {
                                                    System.out.println("Doctor Id:"+doctor_id.get(i));
                                                    System.out.println("Doctor Name:"+doctor_name.get(i));
                                                    System.out.println("Doctor Department Id:"+doctor_dep_id.get(i));
                                                    System.out.println("Number of Patients:"+number_of_patients.get(i));
                                                }
                                            }
                                            break;
                                        case 2:
                                            for(int i=0;i<patient_id.size();i++)
                                            {
                                                if(department_name.get(i)==name && patient_dep_id.get(i)==department_id.get(i))
                                                {
                                                    System.out.println("Patient Id:"+patient_id.get(i));
                                                    System.out.println("Patient Name:"+patient_name.get(i));
                                                    System.out.println("Patient Phone Number:"+patient_phno);
                                                    System.out.println("Patient Problem:"+patient_problem);
                                                    System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                    System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                }
                                            }
                                            break;
                                        case 3:
                                            System.out.println("1.Doctor Id\n2.Doctor Name");
                                            System.out.print("Enter your choice:");
                                            choice=s.nextInt();
                                            switch(choice)
                                            {
                                                case 1:
                                                    System.out.println("Enter Doctor ID:");
                                                    int doc_id=s.nextInt();
                                                    for(int i=0;i<doctor_name.size();i++)
                                                    {
                                                        if(department_name.get(i)==name && doctor_id.get(i)==doc_id);
                                                        {
                                                            System.out.println("Doctor Id:"+doctor_id.get(i));
                                                            System.out.println("Doctor Name:"+doctor_name.get(i));
                                                            System.out.println("Doctor Department Id:"+doctor_dep_id.get(i));
                                                            System.out.println("Number of Patients:"+number_of_patients.get(i));
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Enter Doctor Name:");
                                                    String doc_name=s.nextLine();
                                                    for(int i=0;i<doctor_id.size();i++)
                                                    {
                                                        if(department_name.get(i)==name && doctor_name.get(i)==doc_name);
                                                        {
                                                            System.out.println("Doctor Id:"+doctor_id.get(i));
                                                            System.out.println("Doctor Name:"+doctor_name.get(i));
                                                            System.out.println("Doctor Department Id:"+doctor_dep_id.get(i));
                                                            System.out.println("Number of Patients:"+number_of_patients.get(i));
                                                        }
                                                    }
                                                    break;
                                                default:System.out.println("Choose valid option");
                                            }
                                            break;
                                        case 4:
                                            System.out.println("1.Patient Id\n2.Patient Name\n3.Patient Joined Date");
                                            System.out.print("Enter your choice:");
                                            choice=s.nextInt();
                                            switch(choice)
                                            {
                                                case 1:
                                                    System.out.println("Enter Patient ID:");
                                                    int pat_id=s.nextInt();
                                                    for(int i=0;i<patient_name.size();i++)
                                                    {
                                                        if(department_name.get(i)==name && patient_id.get(i)==pat_id);
                                                        {
                                                            System.out.println("Patient Id:"+patient_id.get(i));
                                                            System.out.println("Patient Name:"+patient_name.get(i));
                                                            System.out.println("Patient Phone Number:"+patient_phno);
                                                            System.out.println("Patient Problem:"+patient_problem);
                                                            System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                            System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    System.out.println("Enter Patient Name:");
                                                    String pat_name=s.nextLine();
                                                    for(int i=0;i<patient_name.size();i++)
                                                    {
                                                        if(department_name.get(i)==name && patient_name.get(i)==pat_name);
                                                        {
                                                            System.out.println("Patient Id:"+patient_id.get(i));
                                                            System.out.println("Patient Name:"+patient_name.get(i));
                                                            System.out.println("Patient Phone Number:"+patient_phno);
                                                            System.out.println("Patient Problem:"+patient_problem);
                                                            System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                            System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("Enter Patient Joined Date:");
                                                    String da=s.nextLine();
                                                    for(int i=0;i<joined_date.size();i++)
                                                    {
                                                        if(department_name.get(i)==name && joined_date.get(i)==da);
                                                        {
                                                            System.out.println("Patient Id:"+patient_id.get(i));
                                                            System.out.println("Patient Name:"+patient_name.get(i));
                                                            System.out.println("Patient Phone Number:"+patient_phno);
                                                            System.out.println("Patient Problem:"+patient_problem);
                                                            System.out.println("Doctor Department Id:"+patient_dep_id.get(i));
                                                            System.out.println("Patient Joined Date:"+joined_date.get(i));
                                                        }
                                                    }
                                                    break;
                                                default:System.out.println("Choose valid option");
                                            }
                                            break;
                                        default:System.out.println("Choose valid option");
                                    }
                                    break;
                                default:System.out.println("Choose valid option");
                            }
                            break;
                        default:System.out.println("Choose valid option");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:System.out.println("Choose valid option");
            }
        }
    }
}