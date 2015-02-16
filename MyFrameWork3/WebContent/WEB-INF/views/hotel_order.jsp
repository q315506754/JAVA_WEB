<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="row">
	<div class="col-xs-12 col-sm-12 col-md-7 col-lg-4">
		<h1 class="page-title txt-color-blueDark"><i class="fa-fw fa fa-glass"></i>酒店服务<span>>酒店预订</span></h1>
	</div>
</div>

<div class="row">
	<div class="jarviswidget jarviswidget-color-blueDark" data-widget-custombutton="true">
		<header>
			<span class="widget-icon"><i class="fa fa-glass"></i></span>
			<h2>酒店预订</h2>
		</header>
		<!-- widget div -->
		<div>
			<!-- widget content -->
			<div class="widget-body">
				<form class="smart-form">
					<fieldset>
						<section>
							<div class="row">
								<div class="form-group">
										<label class="label col col-2">省/市</label>
										<div class="col col-3">
											<select style="width:100%" class="select2" id="city">
												<optgroup label="Alaskan/Hawaiian Time Zone">
													<option value="AK">Alaska</option>
													<option value="HI">Hawaii</option>
												</optgroup>
												<optgroup label="Pacific Time Zone">
													<option value="CA">California</option>
													<option value="NV">Nevada</option>
													<option value="OR">Oregon</option>
													<option value="WA">Washington</option>
												</optgroup>
											</select>
										</div>
								</div>
							
								<div class="form-group">
										<label class="label col col-2">区/县</label>
										<div class="col col-3">
											<select style="width:100%" class="select2" id="area">
												<optgroup label="Alaskan/Hawaiian Time Zone">
													<option value="AK">Alaska</option>
													<option value="HI">Hawaii</option>
												</optgroup>
												<optgroup label="Pacific Time Zone">
													<option value="CA">California</option>
													<option value="NV">Nevada</option>
													<option value="OR">Oregon</option>
													<option value="WA">Washington</option>
												</optgroup>
											</select>
										</div>
								</div>
							</div>
						</section>
						
						<section>
							<div class="row">
								<div class="form-group">
										<label class="label col col-2">入住时间</label>
										<div class="col col-3">
											<div class="input-group">
												<input type="text" id="stDate" placeholder="选择入住时间" class="form-control datepicker" data-dateformat="yy-mm-dd">
												<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
								</div>
							
								<div class="form-group">
										<label class="label col col-2">离店时间</label>
										<div class="col col-3">
											<div class="input-group">
												<input type="text" id="edDate" placeholder="选择离店时间" class="form-control datepicker" data-dateformat="yy-mm-dd">
												<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
								</div>
							</div>
						</section>
						
						<section>
							<div class="row">
								<div class="form-group">
									<label class="label col col-2">间数</label>
									<div class="col col-3">
										<label class="select"><select style="width:100%" id="roomNum">
												<option value=1>1</option>
												<option value=2>2</option>
												<option value=3>3</option>
												<option value=4>4</option>
												<option value=5>5</option>
												<option value=6>6</option>
												<option value=7>7</option>
												<option value=8>8</option>
												<option value=9>9</option>
												<option value=10>10</option>
										</select><i></i></label>
									</div>
								</div>
								<div class="form-group">
									<label class="label col col-2">房型</label>
									<div class="col col-3">
										<label class="select"><select style="width:100%" id="roomType">
												<option value="b">大床</option>
												<option value="d">双床</option>
												<option value="a">皆可</option>
										</select><i></i></label>
									</div>
								</div>
							</div>
						</section>
					</fieldset>
					<footer><button class="btn btn-primary" id="btnOrder">提交</button></footer>
				</form>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="js/page/hotel/order/hotel_order.js"></script>