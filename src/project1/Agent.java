package project1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * Your Agent for solving Raven's Progressive Matrices. You MUST modify this
 * file.
 * 
 * You may also create and submit new files in addition to modifying this file.
 * 
 * Make sure your file retains methods with the signatures:
 * public Agent()
 * public char Solve(RavensProblem problem)
 * 
 * These methods will be necessary for the project's main method to run.
 * 
 */
public class Agent {
    /**
     * The default constructor for your Agent. Make sure to execute any
     * processing necessary before your Agent starts solving problems here.
     * 
     * Do not add any variables to this signature; they will not be used by
     * main().
     * 
     */
    public Agent() {
        
    }
    /**
     * The primary method for solving incoming Raven's Progressive Matrices.
     * For each problem, your Agent's Solve() method will be called. At the
     * conclusion of Solve(), your Agent should return a String representing its
     * answer to the question: "1", "2", "3", "4", "5", or "6". These Strings
     * are also the Names of the individual RavensFigures, obtained through
     * RavensFigure.getName().
     * 
     * In addition to returning your answer at the end of the method, your Agent
     * may also call problem.checkAnswer(String givenAnswer). The parameter
     * passed to checkAnswer should be your Agent's current guess for the
     * problem; checkAnswer will return the correct answer to the problem. This
     * allows your Agent to check its answer. Note, however, that after your
     * agent has called checkAnswer, it will *not* be able to change its answer.
     * checkAnswer is used to allow your Agent to learn from its incorrect
     * answers; however, your Agent cannot change the answer to a question it
     * has already answered.
     * 
     * If your Agent calls checkAnswer during execution of Solve, the answer it
     * returns will be ignored; otherwise, the answer returned at the end of
     * Solve will be taken as your Agent's answer to this problem.
     * 
     * @param problem the RavensProblem your agent should solve
     * @return your Agent's answer to this problem
     */
    public String Solve(RavensProblem problem) {
    	
    	String solution = "1";
    	
    	//I am in the Phase 1 branch
    	//Check which algorithm to use
    	if(problem.getProblemType().toString().equals("2x1")) {
    		
    		//Get All figures 
            HashMap<String, RavensFigure> figures = problem.getFigures();
            
            //Populate frame A figures to array list
            ArrayList<RavensObject> frameAObjects = figures.get("A").getObjects();
            FrameA frameA = new FrameA(frameAObjects);

            //Populate frame A figures to array list
            ArrayList<RavensObject> frameBObjects = figures.get("B").getObjects();
            FrameB frameB = new FrameB(frameBObjects);
            
            //Populate frame A figures to array list
            ArrayList<RavensObject> frameCObjects = figures.get("C").getObjects();
            FrameC frameC = new FrameC(frameCObjects);
            
            //Build semantic network for frames A and B
            SemanticNetworkAB snAB = new SemanticNetworkAB(frameA, frameB);
         
            snAB.generateTransformations();
            
            //Generate frame solution
            FrameGenerated generatedSolution = new FrameGenerated(snAB, frameC);
            generatedSolution.createFrame();
            
            //Check against all possible solutions and return
            String finalSolution = generatedSolution.retrieveSolution(figures);

            solution = finalSolution;
            
            System.out.println("Finished Problem");
             
    	}
    	
        return solution;
    }
}