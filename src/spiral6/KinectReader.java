package spiral6;

import edu.ufl.digitalworlds.j4k.Skeleton;

public class KinectReader {

	public static void AngleCalculator(Skeleton s){
		
		/*System.out.println("Left shoulder: " + skeletons[i].get3DJointX(Skeleton.SHOULDER_LEFT) + "," + skeletons[i].get3DJointY(Skeleton.SHOULDER_LEFT) + "," + skeletons[i].get3DJointZ(Skeleton.SHOULDER_LEFT));
		System.out.println("Left elbow: " + skeletons[i].get3DJointX(Skeleton.ELBOW_LEFT) + "," + skeletons[i].get3DJointY(Skeleton.ELBOW_LEFT) + "," + skeletons[i].get3DJointZ(Skeleton.ELBOW_LEFT));
		System.out.println("Left wrist: " + skeletons[i].get3DJointX(Skeleton.WRIST_LEFT) + "," + skeletons[i].get3DJointY(Skeleton.WRIST_LEFT) + "," + skeletons[i].get3DJointZ(Skeleton.WRIST_LEFT));
		System.out.println();
		
		System.out.println("Right shoulder: " + skeletons[i].get3DJointX(Skeleton.SHOULDER_RIGHT) + "," + skeletons[i].get3DJointY(Skeleton.SHOULDER_RIGHT) + "," + skeletons[i].get3DJointZ(Skeleton.SHOULDER_RIGHT));
		System.out.println("Right elbow: " + skeletons[i].get3DJointX(Skeleton.ELBOW_RIGHT) + "," + skeletons[i].get3DJointY(Skeleton.ELBOW_RIGHT) + "," + skeletons[i].get3DJointZ(Skeleton.ELBOW_RIGHT));
		System.out.println("Right wrist: " + skeletons[i].get3DJointX(Skeleton.WRIST_RIGHT) + "," + skeletons[i].get3DJointY(Skeleton.WRIST_RIGHT) + "," + skeletons[i].get3DJointZ(Skeleton.WRIST_RIGHT));
		System.out.println(i + "----------------------------------------");
		*/
		
		//seems like skeletal data is only captured on a 6 frame interval, and that i is set as a constant between 0 and 5
	
		/*
		 * ste = Shoulder to Elbow distance
		 * wte = Wrist to Elbow distance
		 * stw = Shoulder to Wrist distance
		 * 
		 * squares are those distances squared, respectively
		 * 
		 * Formula to calculate angle between three points can be found here: http://stackoverflow.com/questions/1211212/how-to-calculate-an-angle-from-three-points
		 * Although, I did derive it myself.
		 */
		
		double ste = Math.sqrt(Math.pow(s.get3DJointX(Skeleton.SHOULDER_RIGHT) - s.get3DJointX(Skeleton.ELBOW_RIGHT), 2) + Math.pow(s.get3DJointY(Skeleton.SHOULDER_RIGHT) - s.get3DJointY(Skeleton.ELBOW_RIGHT), 2));
		double wte = Math.sqrt(Math.pow(s.get3DJointX(Skeleton.WRIST_RIGHT) - s.get3DJointX(Skeleton.ELBOW_RIGHT), 2) + Math.pow(s.get3DJointY(Skeleton.WRIST_RIGHT) - s.get3DJointY(Skeleton.ELBOW_RIGHT), 2));
		double stw = Math.sqrt(Math.pow(s.get3DJointX(Skeleton.SHOULDER_RIGHT) - s.get3DJointX(Skeleton.WRIST_RIGHT), 2) + Math.pow(s.get3DJointY(Skeleton.SHOULDER_RIGHT) - s.get3DJointY(Skeleton.WRIST_RIGHT), 2));
		
		double stesquare = Math.pow(ste, 2);
		double wtesquare = Math.pow(wte, 2);
		double stwsquare = Math.pow(stw, 2);
		
		double degree = Math.toDegrees(Math.acos((stesquare+wtesquare-stwsquare)/(2*ste*wte)));
		
		System.out.printf("%.2f degrees\n", degree);
		System.out.print("------------------------\n\n");
		
		
	}
	
	
	
}
