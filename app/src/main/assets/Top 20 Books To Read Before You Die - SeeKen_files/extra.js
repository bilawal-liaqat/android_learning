jQuery(document).ready(function($){var url=window.location.href;if(url.indexOf("seeken.in/blog/")!=-1){$.ajax({url:"/wp-content/extra.php",data:'blog=header_image',success:function(result){url=$.trim(result);$('#primary').css('background-image','url('+ url+')');}});}else if(url.indexOf("seeken.in/downloads/")!=-1){}else if(url.indexOf("seeken.in/service")!=-1){$("#pirate-forms-contact-subject").val('Regarding Whiteboard Animation Video').parent().removeClass('is-empty');$('#ptp-356-cta-0').live('click',function(e){e.preventDefault();$("#pirate-forms-contact-subject").val("Basic: Regarding Whiteboard Animation Video");$('html, body').animate({scrollTop:$("#custom_contact").offset().top- 100},1000);});$('#ptp-356-cta-1').live('click',function(e){e.preventDefault();$("#pirate-forms-contact-subject").val("Standard: Regarding Whiteboard Animation Video");$('html, body').animate({scrollTop:$("#custom_contact").offset().top- 100},1000);});$('#ptp-356-cta-2').live('click',function(e){e.preventDefault();$("#pirate-forms-contact-subject").val("Premium: Regarding Whiteboard Animation Video");$('html, body').animate({scrollTop:$("#custom_contact").offset().top- 100},1000);});$('#ptp-356-cta-3').live('click',function(e){e.preventDefault();$("#pirate-forms-contact-subject").val("Platinum: Regarding Whiteboard Animation Video");$('html, body').animate({scrollTop:$("#custom_contact").offset().top- 100},1000);});}else if(url.indexOf("/category/")!=-1){var slug=url.split('/category/')[1].replace('/','');$.ajax({url:"/wp-content/plugins/categories-images/hook.php",data:'slug='+ slug,success:function(result){url=$.trim(result);$('#primary').css('background-image','url('+ url+')');}});}else if(url.indexOf("/tag/")!=-1){var slug=url.split('/tag/')[1].replace('/','');$.ajax({url:"/wp-content/plugins/categories-images/hook.php",data:'slug='+ slug,success:function(result){url=$.trim(result);$('#primary').css('background-image','url('+ url+')');}});}else if(url.indexOf("/download-category/")!=-1){var slug=url.split('/download-category/')[1].replace('/','');$.ajax({url:"/wp-content/plugins/categories-images/hook.php",data:'slug='+ slug,success:function(result){url=$.trim(result);$('#primary').css('background-image','url('+ url+')');}});}});