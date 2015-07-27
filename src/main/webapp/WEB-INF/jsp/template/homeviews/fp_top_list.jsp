<?php
  // do init stuff here
  switch($category) {
    case BE_ACCOMMODATION:
      $lang = $this->lang->load('accommodation');
      $lang = $this->lang->line('accommodation');
      $url_path = "accommodation/";
      $id = "accomodation_id";
      $name_column = "name";
      $description_column = "largedescription";
      $category_name = "accommodation";
      $title = $lang['page_title'];
      break;
    case BE_JOBS:
      $lang = $this->lang->load('jobs');
      $lang = $this->lang->line('jobs');
      $url_path = "jobs/";
      $id = "job_id";
      $name_column = "title";
      $description_column = "description";
      $category_name = "business";
      $title = $lang['page_title'];
      break;
    case BE_BUSINESS_DIRECTORY:
      $lang = $this->lang->load('business');
      $lang = $this->lang->line('business');
      $url_path = "business/";
      $id = "businessid";
      $name_column = "name";
      $description_column = "largedescription";
      $category_name = "business";
      $title = $lang['page_title'];
      break;
    case BE_NIGHTLIFE:
      $lang = $this->lang->load('nightlife');
      $lang = $this->lang->line('nightlife');
      $url_path = "nightlife/";
      $id = "club_id";
      $name_column = "name";
      $description_column = "largedescription";
      $category_name = "nightlife";
      $title = $lang['page_title'];
      break;
    case BE_DINING:
      $lang = $this->lang->load('dining');
      $lang = $this->lang->line('dining');
      $url_path = "dining/";
      $id = "dining_id";
      $name_column = "name";
      $description_column = "largedescription";
      $category_name = "dining";
      $title = $lang['page_title'];
      break;
    case BE_THINGS_TO_DO:
      $lang = $this->lang->load('thingstodo');
      $lang = $this->lang->line('thingstodo');
      $url_path = "thingstodo/";
      $id = "landmark_id";
      $name_column = "name";
      $description_column = "largedescription";
      $category_name = "landmarks";
      $title = $lang['page_title'];
      break;
    case BE_SPORT:
      $lang = $this->lang->load('sport');
      $lang = $this->lang->line('sport');
      $url_path = "sport/";
      $id = "sports_id";
      $name_column = "name";
      $description_column = "largedescription";
      $category_name = "sport";
      $title = $lang['page_title'];
      break;
    case BE_SHOPPING:
      $lang = $this->lang->load('shopping');
      $lang = $this->lang->line('shopping');
      $url_path = "shopping/";
      $id = "shop_id";
      $name_column = "name";
      $description_column = "largedescription";
      $category_name = "shopping";
      $title = $lang['page_title'];
      break;
    case BE_LIFESTYLE:
      $lang = $this->lang->load('lifestyle');
      $lang = $this->lang->line('lifestyle');
      $url_path = "lifestyle/";
      $id = "id";
      $name_column = "name";
      $description_column = "largedescription";
      $category_name = "lifestyle";
      $title = $lang['page_title'];
      break;
    case BE_KIDS:
      $lang = $this->lang->load('kids');
      $lang = $this->lang->line('kids');
      $url_path = "kids/";
      $id = "id";
      $name_column = "name";
      $description_column = "largedescription";
      $category_name = "kids";
      $title = $lang['page_title'];
      break;
  }
?>

<!-- top list items start -->
<div
  class="column left">
  <!-- title start -->
        <div class="title">
          <h1>
            <a
              href="${base}"
              title="View All Landmarks"
            >
              <?php echo $title; ?>
            </a>
          </h1>
          <a
            href="${base}"
            title="View All <?php echo $title; ?>"
          >
            Browse All
          </a>
        </div>
  <!-- title end -->

  <?php
    //check to see if an odd or even numbering system has been requested
    if(isset($odd_key) && $odd_key == true)
    {
      $start = 1;
      $inc = 2;
    }
    else if(isset($even_key) && $even_key == true)
    {
      $start = 0;
      $inc = 2;
    }
    else
    {
      $start = 0;
      $inc = 1;
    }

    // show an error message if there were no items returned
    if(sizeof($items) == 0) {
      ?>
        <div class='error'>
          <?php
            $t = $this->lang->line('common');
            echo $t['no_items'];
          ?>
        </div>
      <?php
    } else {
      for($i = $start; $i < sizeof($items); $i += $inc)
      {
        ?>
          <!-- item start -->
          <div class="item <?php if(($i+$inc) >= sizeof($items)) {echo " last";} ?>">
            <div class="content">
              <div class="image">
                <a
                  href="<?php
										switch($category) {
											case BE_ACCOMMODATION:
											case BE_JOBS:
											case BE_COMMUNITY:
												echo base_url() . $url_path . "view/" . $items[$i][$id];
												break;
											default:
												echo base_url() . $url_path . "view/" . strtolower(str_replace(array(' ', '&'), array('-', ''), $items[$i][$name_column]));
												break;
										}
									?>"
                  title="Find Out More About <?php echo htmlentities($items[$i][$name_column], ENT_QUOTES); ?>"
                >
                  <?php
                    $img_src = IMAGE_SERVER . "img.png?ct={$category_name}&amp;il={$category_name}_" . strtolower(str_replace(array(' ', '&'), array('_', ''), $items[$i][$name_column])) . '_1&amp;w=80&amp;h=80';
                    if($category == BE_JOBS) {
                      $img_src = IMAGE_SERVER . "img.png?ct={$category_name}&amp;il=business_kershaw_leonard_1&amp;w=80&amp;h=80";
                    }
                  ?>
                  <img src="<?php echo $img_src; ?>"
                    alt="Image of <?php echo htmlentities($items[$i][$name_column], ENT_QUOTES); ?>"
                    width="80"
                    height="80"
                  />
                </a>
              </div>
            </div>
            <div class="text">
              <h2>
                <a
                  href="<?php
										switch($category) {
											case BE_ACCOMMODATION:
											case BE_JOBS:
											case BE_COMMUNITY:
												echo base_url() . $url_path . "view/" . $items[$i][$id];
												break;
											default:
												echo base_url() . $url_path . "view/" . strtolower(str_replace(array(' ', '&'), array('-', ''), $items[$i][$name_column]));
												break;
										}
									?>"
                  title="Find Out More About <?php echo htmlentities($items[$i][$name_column], ENT_QUOTES); ?>"
                >
                  <?php
                    if($show_ln == true) {
                      echo ($i+1) . ". ";
                    }
                    echo htmlentities($items[$i][$name_column], ENT_QUOTES);
                  ?>
                </a>
              </h2>
              <p>
                <a
                  href="<?php
										switch($category) {
											case BE_ACCOMMODATION:
											case BE_JOBS:
											case BE_COMMUNITY:
												echo base_url() . $url_path . "view/" . $items[$i][$id];
												break;
											default:
												echo base_url() . $url_path . "view/" . strtolower(str_replace(array(' ', '&'), array('-', ''), $items[$i][$name_column]));
												break;
										}
									?>"
                  title="Find Out More About <?php echo htmlentities($items[$i][$name_column], ENT_QUOTES); ?>"
                >
                  <?php
                    //echo htmlentities(strip_tags(substr($items[$i][$description_column], 0, 100)) . ' ...', ENT_QUOTES);
                    $desc = $this->lib_bbcode->to_html($items[$i][$description_column], 115);
                  echo $desc;
                  ?>
                </a>
              </p>
              <div class="clear-both"></div>
              <div class="button">
                <a
                  href="<?php
										switch($category) {
											case BE_ACCOMMODATION:
											case BE_JOBS:
											case BE_COMMUNITY:
												echo base_url() . $url_path . "view/" . $items[$i][$id];
												break;
											default:
												echo base_url() . $url_path . "view/" . strtolower(str_replace(array(' ', '&'), array('-', ''), $items[$i][$name_column]));
												break;
										}
									?>"
                  title="Find Out More About <?php echo htmlentities($items[$i][$name_column], ENT_QUOTES); ?>"
                >
                  <?php
                    $nav = $this->lang->line('nav');
                    echo $nav['read_more'];
                  ?>
                </a>
              </div>
            </div>
            <div class="clear-both"></div>
          </div>
          <!-- item end -->
        <?php
      }
    }
  ?>
</div>
