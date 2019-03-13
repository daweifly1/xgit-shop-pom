export interface GoodsAttributeImgReqModel {
        // 主键
        id?:  number;
        // 产品属性分类ID
        goodsId?:  number;
        // 颜色属性
        color?: string;
        // 图片
        pic?: string;
        // 创建人
        dbCreateAuthor?: string;
        // 创建时间
        dbCreateTime?: Date;
        // 更新人
        dbUpdateAuthor?: string;
        // 更新时间
        dbUpdateTime?: Date;
}

this.paramTypeForm = this.formBuilder.group({
    name: [null, [Validators.required, Validators.maxLength(50)]],
    id:[null,[Validators.maxLength(50)]],
    goodsId:[null,[Validators.maxLength(50)]],
    color:[null,[Validators.maxLength(50)]],
    pic:[null,[Validators.maxLength(50)]],
    dbCreateAuthor:[null,[Validators.maxLength(50)]],
    dbCreateTime:[null,[Validators.maxLength(50)]],
    dbUpdateAuthor:[null,[Validators.maxLength(50)]],
    dbUpdateTime:[null,[Validators.maxLength(50)]],

});


<nz-form-item>
    <nz-form-label nzSpan="6"><span class="font-red-color">*</span>主键</nz-form-label>
    <nz-form-control nzSpan="8">
     <input nz-input [(ngModel)]="editData.id" name="id" [maxlength]="100"/>
    </nz-form-control>
</nz-form-item>

<nz-form-item>
    <nz-form-label nzSpan="6"><span class="font-red-color">*</span>产品属性分类ID</nz-form-label>
    <nz-form-control nzSpan="8">
     <input nz-input [(ngModel)]="editData.goodsId" name="goodsId" [maxlength]="100"/>
    </nz-form-control>
</nz-form-item>

<nz-form-item>
    <nz-form-label nzSpan="6"><span class="font-red-color">*</span>颜色属性</nz-form-label>
    <nz-form-control nzSpan="8">
     <input nz-input [(ngModel)]="editData.color" name="color" [maxlength]="100"/>
    </nz-form-control>
</nz-form-item>

<nz-form-item>
    <nz-form-label nzSpan="6"><span class="font-red-color">*</span>图片</nz-form-label>
    <nz-form-control nzSpan="8">
     <input nz-input [(ngModel)]="editData.pic" name="pic" [maxlength]="100"/>
    </nz-form-control>
</nz-form-item>

<nz-form-item>
    <nz-form-label nzSpan="6"><span class="font-red-color">*</span>创建人</nz-form-label>
    <nz-form-control nzSpan="8">
     <input nz-input [(ngModel)]="editData.dbCreateAuthor" name="dbCreateAuthor" [maxlength]="100"/>
    </nz-form-control>
</nz-form-item>

<nz-form-item>
    <nz-form-label nzSpan="6"><span class="font-red-color">*</span>创建时间</nz-form-label>
    <nz-form-control nzSpan="8">
     <input nz-input [(ngModel)]="editData.dbCreateTime" name="dbCreateTime" [maxlength]="100"/>
    </nz-form-control>
</nz-form-item>

<nz-form-item>
    <nz-form-label nzSpan="6"><span class="font-red-color">*</span>更新人</nz-form-label>
    <nz-form-control nzSpan="8">
     <input nz-input [(ngModel)]="editData.dbUpdateAuthor" name="dbUpdateAuthor" [maxlength]="100"/>
    </nz-form-control>
</nz-form-item>

<nz-form-item>
    <nz-form-label nzSpan="6"><span class="font-red-color">*</span>更新时间</nz-form-label>
    <nz-form-control nzSpan="8">
     <input nz-input [(ngModel)]="editData.dbUpdateTime" name="dbUpdateTime" [maxlength]="100"/>
    </nz-form-control>
</nz-form-item>

##############################################################################################

import { Injectable, Injector } from '@angular/core';
import { HttpUtilNs, HttpUtilService } from '../infra/http/http-util.service';
import { Observable } from 'rxjs/Observable';
export namespace GoodsAttributeImgServiceNs {
    export interface UfastHttpResT<T> extends HttpUtilNs.UfastHttpResT<T> {
    }
    export class GoodsAttributeImgServiceClass {
        private http: HttpUtilService;
        private defaultConfig: HttpUtilNs.UfastHttpConfig;
        private barcodeFlagList: { value: number, label: string }[];
        private returnState: { value: number, label: string }[];
        constructor(private injector: Injector) {
            this.http = this.injector.get(HttpUtilService);
            this.defaultConfig = {
                gateway: HttpUtilNs.GatewayKey.Ss
            };
            this.barcodeFlagList = [
                { label: '否', value: 0 },
                { label: '是', value: 1 }
            ];
        }
        public getBarcodeList(): Observable<any> {
            return Observable.of(this.barcodeFlagList);
        }

        /**列表 */
        public getGoodsAttributeImgList(filter): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeImg/list', filter, this.defaultConfig);
        }

        /**新增保存 */
        public addSaveGoodsAttributeImg(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeImg/save', data, this.defaultConfig);
        }
        /**新增提交 */
        public addSubmitGoodsAttributeImg(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeImg/submit', data, this.defaultConfig);
        }
        /**详情 */
        public getGoodsAttributeImgDetail(id: string): Observable<UfastHttpResT<any>> {
            return this.http.Get<UfastHttpResT<any>>('/goodsAttributeImg/item', { id: id }, this.defaultConfig);
        }
        /**结单 */
        public finishGoodsAttributeImg(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeImg/endBill', data, this.defaultConfig);
        }
        /**删除 */
        public deletePurchaseOut(ids: any[]): Observable<UfastHttpResT<any>> {
            return this.http.Post('/goodsAttributeImg/delete', ids, this.defaultConfig);
        }
    }
}

@Injectable()
export class GoodsAttributeImgService extends GoodsAttributeImgServiceNs.GoodsAttributeImgServiceClass {
    constructor(injector: Injector) {
        super(injector);
    }
}

###########################################################################################

