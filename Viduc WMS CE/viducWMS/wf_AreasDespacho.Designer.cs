namespace viducWMS
{
    partial class wf_AreasDespacho
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.dgAreasDespacho = new System.Windows.Forms.DataGrid();
            this.btnCancelar = new System.Windows.Forms.Button();
            this.txtDescripcionProducto = new System.Windows.Forms.TextBox();
            this.txtAreaDespachar = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // dgAreasDespacho
            // 
            this.dgAreasDespacho.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            this.dgAreasDespacho.Location = new System.Drawing.Point(5, 43);
            this.dgAreasDespacho.Name = "dgAreasDespacho";
            this.dgAreasDespacho.Size = new System.Drawing.Size(230, 193);
            this.dgAreasDespacho.TabIndex = 2;
            this.dgAreasDespacho.KeyUp += new System.Windows.Forms.KeyEventHandler(this.dgAreasDespacho_KeyUp);
            this.dgAreasDespacho.Click += new System.EventHandler(this.dgAreasDespacho_Click);
            // 
            // btnCancelar
            // 
            this.btnCancelar.BackColor = System.Drawing.Color.Navy;
            this.btnCancelar.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.btnCancelar.ForeColor = System.Drawing.Color.White;
            this.btnCancelar.Location = new System.Drawing.Point(153, 263);
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(82, 30);
            this.btnCancelar.TabIndex = 3;
            this.btnCancelar.Text = "Cancelar";
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // txtDescripcionProducto
            // 
            this.txtDescripcionProducto.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.txtDescripcionProducto.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.txtDescripcionProducto.Location = new System.Drawing.Point(5, 4);
            this.txtDescripcionProducto.Multiline = true;
            this.txtDescripcionProducto.Name = "txtDescripcionProducto";
            this.txtDescripcionProducto.Size = new System.Drawing.Size(230, 35);
            this.txtDescripcionProducto.TabIndex = 5;
            // 
            // txtAreaDespachar
            // 
            this.txtAreaDespachar.BackColor = System.Drawing.Color.White;
            this.txtAreaDespachar.Location = new System.Drawing.Point(117, 239);
            this.txtAreaDespachar.Name = "txtAreaDespachar";
            this.txtAreaDespachar.Size = new System.Drawing.Size(118, 21);
            this.txtAreaDespachar.TabIndex = 0;
            this.txtAreaDespachar.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtAreaDespachar_KeyUp);
            // 
            // label2
            // 
            this.label2.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label2.ForeColor = System.Drawing.Color.Navy;
            this.label2.Location = new System.Drawing.Point(7, 242);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(109, 14);
            this.label2.Text = "Area de despacho:";
            // 
            // wf_AreasDespacho
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.txtAreaDespachar);
            this.Controls.Add(this.txtDescripcionProducto);
            this.Controls.Add(this.btnCancelar);
            this.Controls.Add(this.dgAreasDespacho);
            this.Name = "wf_AreasDespacho";
            this.Text = "Areas de despacho";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGrid dgAreasDespacho;
        private System.Windows.Forms.Button btnCancelar;
        private System.Windows.Forms.TextBox txtDescripcionProducto;
        private System.Windows.Forms.TextBox txtAreaDespachar;
        private System.Windows.Forms.Label label2;
    }
}