jQuery(function($){$('.input-group input').on('focus',function(){$(this).parent().find('.input-group-addon').addClass('input-group-addon-active');});$('.input-group input').on('blur',function(){$(this).parent().find('.input-group-addon').removeClass('input-group-addon-active');});$('body').on('click','.inddl',function(){var tis=this;$.post(wpdm_site_url,{wpdmfileid:$(this).data('pid'),wpdmfile:$(this).data('file'),actioninddlpvr:$($(this).data('pass')).val()},function(res){res=res.split('|');var ret=res[1];if(ret=='error')$($(tis).data('pass')).addClass('input-error');if(ret=='ok')location.href=$(tis).attr('rel')+'&_wpdmkey='+ res[2];});});$('body').on('click','.wpdm-download-locked.pop-over',function(){var $dc=$($(this).attr('href'));if($(this).attr('data-ready')==undefined){$(this).popover({placement:'bottom',html:true,content:function(){return $dc.html()+'<div style="padding-top: 10px;border-top: 1px solid #eeeeee;text-align: right"><button class="btn btn-danger btn-xs po-close" s><i class="fa fa-times-circle"></i> Close</button></div>';}});$(this).attr('data-ready','hide');}
if($(this).attr('data-ready')=='hide'){$(this).popover('show');$(this).attr('data-ready','show');}else if($(this).attr('data-ready')=='show'){$(this).popover('hide');$(this).attr('data-ready','hide');}
return false;});$('body').on('click','.wpdm-indir',function(e){e.preventDefault();$('#xfilelist').load(location.href,{action:'wpdmfilelistcd',pid:$(this).data('pid'),cd:$(this).data('dir')});});$('body').on('click','.po-close',function(){$('.wpdm-download-link').popover('hide');$('.wpdm-download-link').attr('data-ready','hide');});$('body').on('click','.wpdm-btn-play',function(e){e.preventDefault();var player=$('#'+ $(this).data('player'));var btn=$('#'+ this.id);if(btn.data('state')=='playing'){$(this).data('state','paused');player.trigger('pause');$(this).html("<i class='fa fa-play'></i>");return false;}
if(btn.data('state')=='paused'){$(this).data('state','playing');player.trigger('play');$('.wpdm-btn-play').html("<i class='fa fa-play'></i>");$(this).html("<i class='fa fa-pause'></i>");return false;}
player.attr('src',$(this).data('song')+"&play=song.mp3");player.slideDown();$('.wpdm-btn-play').data("state","stopped");$('.wpdm-btn-play').html("<i class='fa fa-play'></i>");btn.html("<i class='fa fa-spinner fa-spin'></i>");player.unbind('loadedmetadata');player.on('loadedmetadata',function(){console.log("Playing "+ this.src+", for: "+ this.duration+"seconds.");btn.html("<i class='fa fa-pause'></i>");btn.data('state','playing');});});var file_frame,dfield;jQuery('body').on('click','.wpdm-media-upload',function(event){event.preventDefault();dfield=jQuery(jQuery(this).attr('rel'));if(file_frame){file_frame.open();return;}
file_frame=wp.media.frames.file_frame=wp.media({title:jQuery(this).data('uploader_title'),button:{text:jQuery(this).data('uploader_button_text')},multiple:false});file_frame.on('select',function(){attachment=file_frame.state().get('selection').first().toJSON();dfield.val(attachment.url);});file_frame.open();});try{}catch(err){}});