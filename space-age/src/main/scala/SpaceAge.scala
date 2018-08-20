object SpaceAge {
  def onMercury(seconds: Double) = onPlanet('Mercury, seconds)
  def onVenus(seconds: Double) = onPlanet('Venus, seconds)
  def onEarth(seconds: Double) = onPlanet('Earth, seconds)
  def onMars(seconds: Double) = onPlanet('Mars, seconds)
  def onJupiter(seconds: Double) = onPlanet('Jupiter, seconds)
  def onSaturn(seconds: Double) = onPlanet('Saturn, seconds)
  def onUranus(seconds: Double) = onPlanet('Uranus, seconds)
  def onNeptune(seconds: Double) = onPlanet('Neptune, seconds)

  private[this] val EarthOrbitalPeriodInSeconds: Int = 31557600

  private[this] val OrbitalPeriodInEarthYearsMap = Map('Mercury -> 0.2408467,
    'Venus -> 0.61519726,
    'Earth -> 1.0,
    'Mars -> 1.8808158,
    'Jupiter -> 11.862615,
    'Saturn -> 29.447498,
    'Uranus -> 84.016846,
    'Neptune -> 164.79132)

  private[this] def onPlanet(planet: Symbol, seconds: Double) = {
    def roundToTwoDecimalPlaces(n: Double) = (n * 100).round / 100.0
    val age = seconds / (OrbitalPeriodInEarthYearsMap(planet) * EarthOrbitalPeriodInSeconds)
    roundToTwoDecimalPlaces(age)
  }
}
