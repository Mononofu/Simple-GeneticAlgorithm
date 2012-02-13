package GeneticAlgorithm

class Population(val individuals: Array[Individual])  {

  val size = individuals.size
  def fittest = individuals reduce { (prev, cur) => if(prev.fitness > cur.fitness) prev else cur }
}

object Population {
  def withSize(size: Int) = new Population(Array.fill(size)(new Individual))
}