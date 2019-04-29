//maybe do observer pattern
//based on java version of this pattern used for cricket app
//  https://www.geeksforgeeks.org/observer-pattern-set-2-implementation/

trait Observer {
  def update(run: Int, wickets: Int, overs: Float)
}

trait Subject {
  def registerObserver(o: Observer)
  def unregisterObserver(o: Observer)
  def notifyObservers()
}

class CricketData extends Subject
  {
    val runs: Int
    val wickets: Int
    val overs: Float
    val observerList: List[Observer]

    def CricketData() {
      //make function to functionally append list

    }

    @Override
    def registerObserver(o: Observer) {
      //add new o to observerlist

    }

    @Override
    def unregisterObserver(o: Observer) {
      //indexOf

    }

    @Override
    def notifyObservers()
    {
      //iterate and call update

    }

    // get latest runs from stadium
    def getLatestRuns()
    {
      // return 90 for simplicity
      return 90
    }

    // get latest wickets from stadium
    def getLatestWickets()
    {
    // return 2 for simplicity
      return 2
    }

    // get latest overs from stadium
    def getLatestOvers()
    {
      // return 90 for simplicity
      return 10.2
    }

    // This method is used update displays
    // when data changes
    def dataChanged()
    {
      //get latest data
      val newRuns = getLatestRuns()
      val newWickets = getLatestWickets()
      val newOvers = getLatestOvers()

      notifyObservers()
    }
  }

class AverageScoreDisplay extends Observer
{
  val runRate: Float
  val predictedScore: Int

  //change to a functional way
  def update(runs: Int, wickets: Int, overs: Float)
  {
    //val runRate = runs/overs
    //val predictedScore = runRate * 50
    display()
  }

  def display()
  {
    println("\nAverage Score Display: \n"
      + "Run Rate: " + runRate +
      "\nPredictedScore: " +
      predictedScore);
  }
}

class CurrentScoreDisplay extends Observer
{
  val runs, wickets: Int
  val overs: Float

  //do functionally
  def update(runs: Int, wickets: Int, overs: Float)
  {
    //this.runs = runs
    //this.wickets = wickets
    //this.overs = overs
    display()
  }

  def display()
  {
    println("\nCurrent Score Display:\n"
      + "Runs: " + runs +
      "\nWickets:" + wickets +
      "\nOvers: " + overs );
  }
}

object Demo {

  def main(args: Array[String]): Unit = {

    // create objects for testing
    val averageScoreDisplay = new AverageScoreDisplay
    val currentScoreDisplay = new CurrentScoreDisplay

    // pass the displays to Cricket data
    val cricketData = new CricketData()

    // register display elements
    cricketData.registerObserver(averageScoreDisplay)
    cricketData.registerObserver(currentScoreDisplay)

    // in real app you would have some logic to
    // call this function when data changes
    cricketData.dataChanged()

    //remove an observer
    cricketData.unregisterObserver(averageScoreDisplay)

    // now only currentScoreDisplay gets the
    // notification
    cricketData.dataChanged()
  }
}
