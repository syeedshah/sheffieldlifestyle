 <!-- get the weather data 
<?php
  // get the weather data fromt he database
  $q = Doctrine_Query::create()
    ->select('w.temp_f, w.temp_c')
    ->from('Weather w')
    ->limit(1)
    ->orderBy('w.id DESC')
    ->fetchArray();

    // get common lang properties
    $common_lang = $this->lang->line('common');
?>
-->
<div id="weather_widget">
  <h2>Weather</h2>
  <p>'50 temp_f']}&deg F / {$q[0]['temp_c']}&deg; C"; ?></p>
</div>